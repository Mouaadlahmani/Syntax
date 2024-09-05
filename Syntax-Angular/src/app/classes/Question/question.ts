import {Cours} from "../Cours/cours";
import {Quiz} from "../Quiz/quiz";

export class Question {
  id!: number;
  questionTitle!: string;
  option1!: string;
  option2!: string;
  option3!: string;
  rightAnswer!: string;
  difficultyLevel!: string;
  cours!: Cours;
  quizzes!: Quiz;
}
