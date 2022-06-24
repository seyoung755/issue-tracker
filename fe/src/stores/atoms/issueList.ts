import { atom } from 'recoil';

import { IssueListType } from '@/types/IssueType';

export const ISSUE_LIST_ATOM_KEY = 'issueListState' as const;

export const issueListState = atom<IssueListType>({
  key: ISSUE_LIST_ATOM_KEY,
  default: {
    openCount: 0,
    closeCount: 0,
    issues: [],
  },
});
