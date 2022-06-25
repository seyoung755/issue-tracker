export interface CommentType {
  content: string;
  author: {
    userId: string;
    profileImage: string;
    username: string;
  };
  createdAt: string;
}
