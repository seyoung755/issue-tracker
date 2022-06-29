import * as S from '../style';
import DropdownContainer from './DropdownContainer';
import LabelDropdown from './LabelDropdown';
import MilestoneDropdown from './MilestoneDropdown';
import UserDropdown from './UserDropdown';

const DropdownTextButtons = [
  { id: 'assignee', header: '담당자', DropdownComponent: UserDropdown },
  { id: 'label', header: '레이블', DropdownComponent: LabelDropdown },
  { id: 'milestone', header: '마일스톤', DropdownComponent: MilestoneDropdown },
  { id: 'writer', header: '작성자', DropdownComponent: UserDropdown },
];

export default function DropdownTextButtonList() {
  return (
    <S.DropdownTextButtonContainer>
      {DropdownTextButtons.map(({ id, header, DropdownComponent }) => (
        <DropdownContainer key={id} id={id} header={header} DropdownComponent={DropdownComponent} />
      ))}
    </S.DropdownTextButtonContainer>
  );
}
