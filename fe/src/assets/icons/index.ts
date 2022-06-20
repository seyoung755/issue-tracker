import angleDown from './angle-down.svg';
import boxCloseIssue from './box-close-issue.svg';
import cancelX from './cancel-x.svg';
import circleCheck from './circle-check.svg';
import circleEmpty from './circle-empty.svg';

export const Icons = {
  angleDown,
  boxCloseIssue,
  cancelX,
  circleCheck,
  circleEmpty,
} as const;

export type IconsType = keyof typeof Icons;
