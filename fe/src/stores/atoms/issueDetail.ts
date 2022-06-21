import { atom } from 'recoil';

export const ISSUE_DETAIL_ATOM_KEY = 'issueDetailState' as const;

export interface IssueDetailType {
  id: string;
  title: string;
  content: string;
  createdAt: string;
  author: {
    userId: string;
    profileImage: string;
    username: string;
  };
  assignees: [
    {
      username: string;
      profileImage: string;
    },
  ];
  label: {
    labelName: string;
    description: string;
    colorCode: string;
    textColor: string;
  };
  milestone: {
    name: string;
    dueDate: string;
    description: string;
    progressRate: number;
    openCount: number;
    closeCount: number;
  };
  // TODO: comment 별도의 atom으로 뺄지 얘기해보기
  comments: [
    {
      content: string;
      author: {
        userId: string;
        profileImage: string;
        username: string;
      };
      createdAt: string;
    },
  ];
}

export const issueDetailState = atom<IssueDetailType | null | undefined>({
  key: ISSUE_DETAIL_ATOM_KEY,
  default: null,
});
