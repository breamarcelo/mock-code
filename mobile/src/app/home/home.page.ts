import { Component, OnInit } from '@angular/core';
import { IonHeader, IonToolbar, IonTitle, IonContent, IonCard, IonCardHeader, IonCardTitle, IonCardSubtitle, IonCardContent, IonButton } from '@ionic/angular/standalone';
import { PresupuestoService } from '../api/presupuesto-service';
import { Presupuesto } from '../model/Presupuesto.model';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
  imports: [IonHeader, IonToolbar, IonTitle, IonContent, IonCard, IonCardHeader, IonCardTitle, IonCardSubtitle, IonCardContent, IonButton],
})
export class HomePage implements OnInit {
  presupuesto?: Presupuesto;

  constructor(private presupuestoService: PresupuestoService) { }

  ngOnInit(): void {
    this.presupuestoService.getAll().subscribe({
      next: (data) => {
        this.presupuesto = data;
        alert(JSON.stringify(data));
      },
      error: (err) => console.error('Error al conectar con Spring Boot', err)
    })
  }


}
