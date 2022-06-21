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
    openCount: 3,
    closeCount: 3,
    issues: [
      {
        id: 'adfas0-asdfasdf',
        createdAt: '2022-06-20T13:42:01.848Z',
        labelName: 'fe',
        milestoneName: 'string',
        author: {
          userId: 'adfas0-asdfasdf',
          profileImage: 'string',
          username: 'string',
        },
      },
    ],
  },
});
