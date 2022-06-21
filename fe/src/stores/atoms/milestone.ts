import { atom } from 'recoil';

export const MILESTONE_ATOM_KEY = 'milestoneState' as const;

export interface MilestoneTypes {
  name: string;
  dueDate: string; // TODO: yyyy-mm-dd 커스텀 타입으로 변경하기
  description: string;
  progressRate: number;
  openCount: number;
  closeCount: number;
}

export interface MilestoneListTypes {
  totalCount: number;
  milestones: MilestoneTypes[];
}

export const milestoneState = atom<MilestoneListTypes | null | undefined>({
  key: MILESTONE_ATOM_KEY,
  default: null,
});
