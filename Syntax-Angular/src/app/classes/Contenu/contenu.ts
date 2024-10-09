import {Lecon} from "../Lecon/lecon";

export class Contenu {
  id!:number;
  titre!:string;
  description!:string;
  lecon?:Lecon;
}
