export interface LabelType {
  labelName: string;
  description: string;
  colorCode: string;
  textColor: string;
}

export interface LabelListType {
  totalCount: number;
  labels: LabelType[];
}
