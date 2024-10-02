import {Cours} from "../Cours/cours";
import {Utilisateur} from "../Utilisateur/utilisateur";

export class Certificat {
  id?: number;
  dateObtention!: Date;
  utilisateur!: Utilisateur;
  courses!: Cours;
}
