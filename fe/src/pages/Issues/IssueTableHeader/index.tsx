import DropdownContainer from './DropdownContainer';
import LabelDropdown from './DropdownContainer/LabelDropdown';
import MilestoneDropdown from './DropdownContainer/MilestoneDropdown';
import UserDropdown from './DropdownContainer/UserDropdown';
import * as S from './style';

const DropdownTextButtonList = [
  { id: 'assignee', header: '담당자', DropdownComponent: UserDropdown },
  { id: 'label', header: '레이블', DropdownComponent: LabelDropdown },
  { id: 'milestone', header: '마일스톤', DropdownComponent: MilestoneDropdown },
  { id: 'writer', header: '작성자', DropdownComponent: UserDropdown },
];

export default function IssueTableHeader() {
  return (
    <S.IssueTableHeader>
      <S.DropdownTextButtonContainer>
        {DropdownTextButtonList.map(({ id, header, DropdownComponent }) => (
          <DropdownContainer
            key={id}
            id={id}
            header={header}
            DropdownComponent={DropdownComponent}
          />
        ))}
      </S.DropdownTextButtonContainer>
    </S.IssueTableHeader>
  );
}
