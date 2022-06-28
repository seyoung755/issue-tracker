import { RecoilValueReadOnly, useRecoilValue } from 'recoil';

import Dropdown, { DropdownProps } from '@/components/Dropdown';
import { LabelListType, LabelType } from '@/types/labelTypes';

import * as S from './style';

interface DropDownListProps extends DropdownProps {
  selector: RecoilValueReadOnly<LabelType[]>;
  header: string;
}

export default function DropDownList({
  parentComponent,
  isOpen,
  onClose,
  selector,
  header,
}: DropDownListProps) {
  const dropdownChildrenList = useRecoilValue(selector);
  console.log('dropdownChildrenList :>> ', dropdownChildrenList);
  return (
    <Dropdown parentComponent={parentComponent} isOpen={isOpen} onClose={onClose}>
      <S.DropdownHeader>{header}필터</S.DropdownHeader>
      <S.DropdownBody>
        {dropdownChildrenList.map(({ labelName, description, textColor, colorCode }) => (
          <li key={labelName}>{labelName}</li>
        ))}
      </S.DropdownBody>
    </Dropdown>
  );
}
