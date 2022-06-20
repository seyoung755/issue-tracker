import { atom } from 'recoil';

export const MILESTONE_ATOM_KEY = 'milestone' as const;

export interface MilestoneTypes {
  name: string;
  dueDate: string; // TODO: yyyy-mm-dd 커스텀 타입으로 변경하기
  description: string;
  progressRate: number;
  openCount: number;
  closeCount: number;
}

export const milestoneState = atom<MilestoneTypes[]>({
  key: MILESTONE_ATOM_KEY,
  default: [
    {
      name: 'string',
      dueDate: '2022-06-20',
      description: 'string',
      progressRate: 0.33,
      openCount: 10,
      closeCount: 20,
    },
    {
      name: 'string',
      dueDate: '2022-06-20',
      description: 'string',
      progressRate: 0.55,
      openCount: 5,
      closeCount: 4,
    },
  ],
});
