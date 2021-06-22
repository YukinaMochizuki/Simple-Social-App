import { Component, Input, OnInit } from '@angular/core';
import { Post } from '../post';
import { Comment } from '../comment';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {

  comment: Comment = {
    name: "",
    content: "",
  };

  @Input() post: Post = {
    name: "",
    type: "",
    time: "",
    location: "",
    content: "",
    pushCount: 0,
    commentCount: 0,
    comment: [this.comment],
  };

  showCommant: boolean = false;

  constructor() { }

  ngOnInit(): void {
  }

  clickComment() {
    console.log("click!!")
    this.showCommant = !this.showCommant;
  }
}
