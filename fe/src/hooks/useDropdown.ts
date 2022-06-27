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

  const handleDropdownClick = (event: MouseEvent) => {
    for (const element of event.composedPath()) {
      if (element === parent.current) return;
    }
    setIsDropdownOpen(false);
  };

  const openDropdown = () => setIsDropdownOpen(true);

  useEffect(() => {
    window.addEventListener('click', handleDropdownClick, true);

    return () => {
      window.removeEventListener('click', handleDropdownClick, true);
    };
  }, [parent]);
  return [parent, isDropdownOpen, openDropdown, handleDropdownClick];
};

export default useDropdown;
