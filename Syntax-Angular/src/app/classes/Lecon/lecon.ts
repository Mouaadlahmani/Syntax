import {Cours} from "../Cours/cours";
import {Contenu} from "../Contenu/contenu";

export class Lecon {
  id!: number;
  titre!: string;
  contenu?: Contenu[];
  courses!: Cours;
}
