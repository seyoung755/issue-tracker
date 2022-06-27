import { useState, Dispatch, SetStateAction, useEffect, useRef, MutableRefObject } from 'react';

type ReturnProps = [
  MutableRefObject<HTMLDivElement>,
  boolean,
  () => void,
  (event: MouseEvent) => void,
];

const usePopup = (initialMode: boolean): ReturnProps => {
  const parent = useRef() as MutableRefObject<HTMLDivElement>;

  const [isPopupOpen, setIsPopupOpen] = useState(initialMode);

  const handleModalClick = (event: MouseEvent) => {
    for (const element of event.composedPath()) {
      if (element === parent.current) return;
    }
    setIsPopupOpen(false);
  };

  const openPopUp = () => setIsPopupOpen(true);

  useEffect(() => {
    window.addEventListener('click', handleModalClick, true);

    return () => {
      window.removeEventListener('click', handleModalClick, true);
    };
  }, [parent]);
  return [parent, isPopupOpen, openPopUp, handleModalClick];
};

export default usePopup;
