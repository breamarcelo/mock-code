import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Presupuesto } from '../model/Presupuesto.model';
import { Result } from '../model/Result.model';

@Injectable({
  providedIn: 'root',
})
export class PresupuestoService {
  private http = inject(HttpClient);

  getAll() {
    return this.http.get<Result[]>('http://localhost:8080/api/presupuestos');
  }

  getById(id: number) {
    return this.http.get<Result>(`http://localhost:8080/api/presupuestos/${id}`);
  }

}
