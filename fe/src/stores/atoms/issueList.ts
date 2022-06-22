import { atom } from 'recoil';

export const ISSUE_LIST_ATOM_KEY = 'issueListState' as const;

export interface IssueType {
  id: string;
  createdAt: string;
  labelName: string;
  milestoneName: string;
  author: {
    userId: string;
    profileImage: string;
    username: string;
  };
}

export interface IssueListTypes {
  openCount: number;
  closeCount: number;
  issues: IssueType[];
}

export const issueListState = atom<IssueListTypes>({
  key: ISSUE_LIST_ATOM_KEY,
  default: {
    openCount: 0,
    closeCount: 0,
    issues: [],
  },
});
