import { LineasPresupuesto } from "./LineasPresupuesto.model";
import { Presupuesto } from "./Presupuesto.model";

export interface Result {
    presupuesto: Presupuesto;
    lineas: LineasPresupuesto[];
    total: number;
}