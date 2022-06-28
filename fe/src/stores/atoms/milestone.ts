import { atom } from 'recoil';

import { MilestoneListType } from '@/types/milestoneType';

export const milestoneListState = atom<MilestoneListType>({
  key: 'milestoneListState',
  default: {
    totalCount: 0,
    milestones: [],
  },
});
