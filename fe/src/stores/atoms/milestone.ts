import { atom } from 'recoil';

import { MilestoneListType } from '@/types/milestoneType';

export const MILESTONE_ATOM_KEY = 'milestoneState' as const;

export const milestoneState = atom<MilestoneListType | null | undefined>({
  key: MILESTONE_ATOM_KEY,
  default: null,
});
