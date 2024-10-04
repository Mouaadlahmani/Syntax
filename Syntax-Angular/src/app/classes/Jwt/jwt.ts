export class Jwt {
  token!:string
  user!: {
    id: number;
    role: string;
    email:string;
  };
}
