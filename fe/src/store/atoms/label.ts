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
    totalCount: 5,
    labels: [
      {
        labelName: 'fe',
        description: 'fe class',
        colorCode: '#273a3e',
        textColor: '#000000',
      },
      {
        labelName: 'be',
        description: 'be class',
        colorCode: '#0f2337',
        textColor: '#000000',
      },
      {
        labelName: 'ios',
        description: 'ios class',
        colorCode: '#382628',
        textColor: '#000000',
      },
      {
        labelName: 'android',
        description: 'android class',
        colorCode: '#d876e3',
        textColor: '#000000',
      },
      {
        labelName: 'etc',
        description: 'etc...',
        colorCode: '#2b3510',
        textColor: '#000000',
      },
    ],
  },
});
