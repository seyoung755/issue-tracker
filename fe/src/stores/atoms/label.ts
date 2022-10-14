import { atom } from 'recoil';

import { LabelListType } from '@/types/labelTypes';

export const labelListState = atom<LabelListType>({
  key: 'labelListState',
  default: {
    totalCount: 0,
    labels: [],
  },
});
