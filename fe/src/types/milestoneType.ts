export interface MilestoneType {
  name: string;
  dueDate: string; // TODO: yyyy-mm-dd 커스텀 타입으로 변경하기
  description: string;
  progressRate: number;
  openCount: number;
  closeCount: number;
}

export interface MilestoneListType {
  totalCount: number;
  milestones: MilestoneType[];
}
