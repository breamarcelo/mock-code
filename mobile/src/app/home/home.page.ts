import { Component, OnInit } from '@angular/core';
import { IonHeader, IonToolbar, IonTitle, IonContent, IonCard, IonCardHeader, IonCardTitle, IonCardSubtitle, IonCardContent, IonButton, IonGrid, IonRow, IonCol } from '@ionic/angular/standalone';
import { PresupuestoService } from '../api/presupuesto-service';
import { Presupuesto } from '../model/Presupuesto.model';
import { Result } from '../model/Result.model';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
  imports: [IonHeader, IonToolbar, IonTitle, IonContent, IonCard, IonCardHeader, IonCardTitle, IonCardSubtitle, IonCardContent, IonButton, IonGrid, IonRow, IonCol],
})
export class HomePage implements OnInit {
  result?: Result[];

  constructor(private presupuestoService: PresupuestoService) { }

  ngOnInit(): void {
    this.presupuestoService.getAll().subscribe({
      next: (data) => {
        this.result = data;
      },
      error: (err) => console.error('Error al conectar con Spring Boot', err)
    })
  }


}
