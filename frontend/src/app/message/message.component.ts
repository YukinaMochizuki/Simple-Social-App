import { Component, OnInit } from '@angular/core';
import { Message } from '../message';
import { MessageService } from '../message.service';

@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.css']
})
export class MessageComponent implements OnInit {

  messages: Message[] = [];
  isLoading: boolean = true;

  constructor(private messageService: MessageService) { }

  ngOnInit(): void {
    this.messageService.getMessages().subscribe(messages => {
      this.messages = messages;
      this.isLoading = false;
    });
  }
}
