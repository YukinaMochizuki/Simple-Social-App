import { Component, OnInit } from '@angular/core';
import { Post } from '../post';
import { PostService } from '../post.service';

@Component({
  selector: 'app-cards',
  templateUrl: './cards.component.html',
  styleUrls: ['./cards.component.css']
})
export class CardsComponent implements OnInit {

  posts: Post[] = [];
  isLoading: boolean = true;

  constructor(private postService: PostService) { }

  ngOnInit(): void {
    this.getPosts();
  }

  getPosts(): void {
    this.isLoading = true;
    this.postService.getPosts().subscribe(posts => {
      this.posts.push(...posts);
      this.isLoading = false;
    });
  }
}
