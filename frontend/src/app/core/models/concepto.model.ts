import { Puesto } from './puesto.model';

export interface Concepto {
  id: number;
  nombre: string;
  monto: number;
  tipo: 'PERCEPCION' | 'DEDUCCION';
  estatus: string;
  puesto: Puesto;
}
