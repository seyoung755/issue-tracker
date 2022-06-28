import { RecoilValueReadOnly, useRecoilValue } from 'recoil';

import { TextButton } from '@/components/Common/Button';
import Icon from '@/components/Common/Icon';
import Dropdown from '@/components/Dropdown';
import useDropdown from '@/hooks/useDropdown';

import DropDownList from './DropDownList';
import * as S from './style';

interface DropdownButtonContainerProps<T> {
  id: string;
  text: string;
  selector: RecoilValueReadOnly<T>;
}

export default function DropdownButtonContainer<T>({
  id,
  text,
  selector,
}: DropdownButtonContainerProps<T>) {
  const [parent, isDropdownOpen, openDropdown, closeDropdown] = useDropdown(false);
  return (
    <TextButton ref={parent} onClick={openDropdown} key={id} customStyle={S.DropdownTextButton}>
      {text}
      <Icon iconName="angleDown" iconSize="base" />
      <DropDownList
        parentComponent={parent}
        isOpen={isDropdownOpen}
        onClose={closeDropdown}
        selector={selector}
      />
    </TextButton>
  );
}
