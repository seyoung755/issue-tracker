import { TextButton } from '@/components/Common/Button';
import { DropdownProps } from '@/components/Common/Dropdown';
import Icon from '@/components/Common/Icon';
import useDropdown from '@/hooks/useDropdown';

import * as S from './style';

interface DropdownContainerProps {
  id: string;
  header: string;
  DropdownComponent: ({}: DropdownProps) => JSX.Element; // FIXME: props를 generic을 활용해서 받을 수는 없을까?
}

export default function DropdownContainer({
  id,
  header,
  DropdownComponent,
}: DropdownContainerProps) {
  const [parent, isDropdownOpen, openDropdown, closeDropdown] = useDropdown(false);
  return (
    <TextButton ref={parent} onClick={openDropdown} key={id} customStyle={S.DropdownTextButton}>
      {header}
      <Icon iconName="angleDown" iconSize="base" />
      <DropdownComponent parentComponent={parent} isOpen={isDropdownOpen} onClose={closeDropdown} />
    </TextButton>
  );
}
