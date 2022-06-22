import angleDown from './angle-down.svg';
import boxCloseIssue from './box-close-issue.svg';
import cancelX from './cancel-x.svg';
import circleCheck from './circle-check.svg';
import circleEmpty from './circle-empty.svg';
import Edit from './edit.svg';
import ExClamationBlue from './exclamation-blue.svg';
import ExClamationNormal from './exclamation-normal.svg';
import Label from './label.svg';
import MilseStone from './milestone.svg';
import PaperClip from './paperclip.svg';
import Plus from './plus.svg';
import Refresh from './refresh.svg';
import Search from './search.svg';
import SmileEmoji from './smile-emoji.svg';
import Trash from './trash.svg';

export const Icons = {
  angleDown,
  boxCloseIssue,
  cancelX,
  circleCheck,
  circleEmpty,
  Edit,
  ExClamationBlue,
  ExClamationNormal,
  Label,
  MilseStone,
  PaperClip,
  Plus,
  Refresh,
  Search,
  SmileEmoji,
  Trash,
} as const;

export type IconsType = keyof typeof Icons;
