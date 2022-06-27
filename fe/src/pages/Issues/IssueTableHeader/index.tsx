import { useState } from 'react';

import { TextButton } from '@/components/Common/Button';
import Icon from '@/components/Common/Icon';
import Dropdown from '@/components/Dropdown';
import useDropdown from '@/hooks/useDropdown';

import * as S from './style';

export default function IssueTableHeader() {
  const [parent, isDropdownOpen, openDropdown, closeDropdown] = useDropdown(false);
  const [info, setInfo] = useState('default');
  const handleDropdownOpen = (id: string) => {
    openDropdown();
    setInfo(id);
  };
  return (
    <S.IssueTableHeader ref={parent}>
      <S.DropdownTextButtonContainer>
        {DropdownLabelList.map(({ id, text }) => (
          <TextButton
            onClick={() => handleDropdownOpen(id)}
            key={id}
            customStyle={S.DropdownTextButton}
          >
            {text}
            <Icon iconName="angleDown" iconSize="base" />
          </TextButton>
        ))}
      </S.DropdownTextButtonContainer>
      <Dropdown parentComponent={parent} isOpen={isDropdownOpen} onClose={closeDropdown}>
        {info}
      </Dropdown>
    </S.IssueTableHeader>
  );
}

const DropdownLabelList = [
  { id: 'assignee', text: '담당자' },
  { id: 'label', text: '레이블' },
  { id: 'milestone', text: '마일스톤' },
  { id: 'writer', text: '작성자' },
];
