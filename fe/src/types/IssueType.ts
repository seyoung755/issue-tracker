import { CommentType } from '@/types/commentType';
import { LabelType } from '@/types/labelTypes';
import { MilestoneType } from '@/types/milestoneType';
import { UserType } from '@/types/userType';

export interface IssueType {
  id: string;
  createdAt: string;
  labelName: string;
  milestoneName: string;
  author: UserType;
}

export interface IssueListType {
  openCount: number;
  closeCount: number;
  issues: IssueType[];
}

export interface IssueInfo {
  id: string;
  title: string;
  content: string;
  createdAt: string;
}

export interface IssueDetailType extends IssueInfo {
  author: UserType;
  assignees: UserType[];
  label: LabelType;
  milestone: MilestoneType;
  comments: CommentType[];
}
