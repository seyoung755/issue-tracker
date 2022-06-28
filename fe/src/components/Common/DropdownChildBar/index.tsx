import { ReactNode, useState } from 'react';

import Icon from '@/components/Common/Icon';

import * as S from './style';

interface DropdownChildBarProps {
  children: ReactNode;
}

export default function DropdownChildBar({ children }: DropdownChildBarProps) {
  const [isSelected, setIsSelected] = useState(false);
  const iconName = isSelected ? 'circleCheck' : 'circleEmpty';
  const handleBarClick = () => {
    setIsSelected(prev => !prev);
    // TODO: 선택된 항목들을 search query로 이동시키는 로직
  };
  return (
    <S.DropdownChildBar onClick={handleBarClick}>
      <S.Info>{children}</S.Info>
      <Icon iconName={iconName} />
    </S.DropdownChildBar>
  );
}
