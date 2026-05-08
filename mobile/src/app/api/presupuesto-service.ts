import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Presupuesto } from '../model/Presupuesto.model';

@Injectable({
  providedIn: 'root',
})
export class PresupuestoService {
  private http = inject(HttpClient);

  getAll() {
    return this.http.get<Presupuesto>('http://localhost:8080/api/presupuestos/1');
  }

}
