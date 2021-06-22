import { Comment } from "./comment";

export interface Post{
    name: string;
    type: string;
    time: string;
    location: string;
    content: string;
    pushCount: number;
    commentCount: number;
    comment: Comment[];
}