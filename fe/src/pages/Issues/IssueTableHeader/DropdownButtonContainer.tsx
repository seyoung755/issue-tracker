import { RecoilValueReadOnly } from 'recoil';

import { TextButton } from '@/components/Common/Button';
import Icon from '@/components/Common/Icon';
import useDropdown from '@/hooks/useDropdown';
import { LabelType } from '@/types/labelTypes';

import DropDownList from './DropDownList';
import * as S from './style';

interface DropdownButtonContainerProps {
  id: string;
  header: string;
  selector: RecoilValueReadOnly<LabelType[]>;
}

export default function DropdownButtonContainer({
  id,
  header,
  selector,
}: DropdownButtonContainerProps) {
  const [parent, isDropdownOpen, openDropdown, closeDropdown] = useDropdown(false);
  return (
    <TextButton ref={parent} onClick={openDropdown} key={id} customStyle={S.DropdownTextButton}>
      {header}
      <Icon iconName="angleDown" iconSize="base" />
      <DropDownList
        parentComponent={parent}
        isOpen={isDropdownOpen}
        onClose={closeDropdown}
        selector={selector}
        header={header}
      />
    </TextButton>
  );
}
