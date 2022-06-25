import { atom } from 'recoil';

import { LabelListType } from '@/types/labelTypes';

export const LABEL_ATOM_KEY = 'labelState' as const;

export const labelState = atom<LabelListType>({
  key: LABEL_ATOM_KEY,
  default: {
    totalCount: 0,
    labels: [],
  },
});
