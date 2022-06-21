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

export const issueListState = atom<IssueDetailType>({
  key: ISSUE_DETAIL_ATOM_KEY,
  default: {
    id: 'adfas0-asdfasdf',
    title: 'string',
    content: 'string',
    createdAt: '2022-06-20T13:44:53.734Z',
    author: {
      userId: 'adfas0-asdfasdf',
      profileImage: 'string',
      username: 'string',
    },
    assignees: [
      {
        username: 'string',
        profileImage: 'string',
      },
    ],
    label: {
      labelName: 'fe',
      description: 'fe class',
      colorCode: '#273a3e',
      textColor: '#000000',
    },
    milestone: {
      name: 'string',
      dueDate: '2022-06-20',
      description: 'string',
      progressRate: 0.33,
      openCount: 10,
      closeCount: 20,
    },
    comments: [
      {
        content: 'string',
        author: {
          userId: 'adfas0-asdfasdf',
          profileImage: 'string',
          username: 'string',
        },
        createdAt: '2022-06-20T13:44:53.734Z',
      },
    ],
  },
});
