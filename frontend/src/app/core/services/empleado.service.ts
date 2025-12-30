import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Empleado } from '../models/empleado.model';

@Injectable({ providedIn: 'root' })
export class EmpleadoService {

  private apiUrl = 'http://localhost:8080/api/empleados';

  constructor(private http: HttpClient) {}

  listar() {
    return this.http.get<Empleado[]>(this.apiUrl);
  }

  crear(data: any) {
    return this.http.post(this.apiUrl, data);
  }

  eliminar(id: number) {
    return this.http.delete(`${this.apiUrl}/${id}`);
  }

  obtenerPorId(id: number) {
  return this.http.get<Empleado>(`${this.apiUrl}/${id}`);
    }

    actualizar(id: number, data: any) {
    return this.http.put(`${this.apiUrl}/${id}`, data);
    }
}
