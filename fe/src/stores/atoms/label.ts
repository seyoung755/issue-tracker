import { atom } from 'recoil';

export const LABEL_ATOM_KEY = 'labelState' as const;

export interface LabelTypes {
  labelName: string;
  description: string;
  colorCode: string;
  textColor: string;
}

export interface LabelListTypes {
  totalCount: number;
  labels: LabelTypes[];
}
export const labelState = atom<LabelListTypes>({
  key: LABEL_ATOM_KEY,
  default: {
    totalCount: 0,
    labels: [],
  },
});
