import {Lecon} from "../Lecon/lecon";

export class Contenu {
  id!:number;
  titre!:string;
  contenu!:string;
  lecon?:Lecon;
}
