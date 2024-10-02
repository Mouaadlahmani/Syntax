import {Certificat} from "../Certificat/certificat";
import {Lecon} from "../Lecon/lecon";
import {Quiz} from "../Quiz/quiz";

export class Cours {
  id!: number;
  titre!: string;
  description!: string;
  certificat: Certificat[]=[];
  lecons: Lecon[]=[];
  questions:[]=[];
}
