import { Puesto } from './puesto.model';

export interface Empleado {
  id: number;
  nombre: string;
  correo: string;
  estatus: string;
  puesto: Puesto;
}
