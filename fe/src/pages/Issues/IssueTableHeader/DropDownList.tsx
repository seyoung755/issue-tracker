import { RecoilValueReadOnly, useRecoilValue } from 'recoil';

import Dropdown, { DropdownProps } from '@/components/Dropdown';

interface DropDownListProps<T> extends DropdownProps {
  selector: RecoilValueReadOnly<T>;
}

export default function DropDownList<T>({
  parentComponent,
  isOpen,
  onClose,
  selector,
}: DropDownListProps<T>) {
  const dropdownChildrenList = useRecoilValue(selector);
  console.log('dropdownChildrenList :>> ', dropdownChildrenList);
  return (
    <Dropdown parentComponent={parentComponent} isOpen={isOpen} onClose={onClose}>
      <div>d</div>
    </Dropdown>
  );
}
