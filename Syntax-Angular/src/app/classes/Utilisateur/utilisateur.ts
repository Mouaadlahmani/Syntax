import {Certificat} from "../Certificat/certificat";
import {Role} from "../enums/Role/role";

export class Utilisateur {
  id?: number;
  nom?: number;
  prenom?: number;
  email?: number;
  password?: number;
  role?: Role;
  certificats?: Certificat[];
}
