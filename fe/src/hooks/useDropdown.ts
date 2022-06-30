import { useState, useEffect, useRef, MutableRefObject } from 'react';

type ReturnProps = [
  MutableRefObject<HTMLDivElement>,
  boolean,
  () => void,
  (event: MouseEvent) => void,
];

const useDropdown = (initialMode: boolean): ReturnProps => {
  const parent = useRef() as MutableRefObject<HTMLDivElement>;

  const [isDropdownOpen, setIsDropdownOpen] = useState(initialMode);

  const closeDropdown = (event: MouseEvent) => {
    for (const element of event.composedPath()) {
      if (element === parent.current) return;
    }
    setIsDropdownOpen(false);
  };

  const openDropdown = () => setIsDropdownOpen(true);

  useEffect(() => {
    window.addEventListener('click', closeDropdown, true);

    return () => {
      window.removeEventListener('click', closeDropdown, true);
    };
  }, [parent]);
  return [parent, isDropdownOpen, openDropdown, closeDropdown];
};

export default useDropdown;
