import { atom } from 'recoil';

import { CommentType } from '@/types/commentType';
import { IssueInfo, IssueListType } from '@/types/IssueType';
import { MilestoneType } from '@/types/milestoneType';
import { UserType } from '@/types/userType';

export const issueDetailInfo = atom<IssueInfo | null | undefined>({
  key: 'issueDetailInfo',
  default: null,
});
export const issueDetailAssginee = atom<UserType | null | undefined>({
  key: 'issueDetailAssginee',
  default: null,
});
export const issueDetailAuthor = atom<UserType | null | undefined>({
  key: 'issueDetailAuthor',
  default: null,
});
export const issueDetailMilestone = atom<MilestoneType | null | undefined>({
  key: 'issueDetailMilestone',
  default: null,
});
export const issueDetailComments = atom<CommentType[] | null | undefined>({
  key: 'issueDetailComments',
  default: null,
});

export const issueListState = atom<IssueListType>({
  key: 'issueListState',
  default: {
    openCount: 0,
    closeCount: 0,
    issues: [],
  },
});
