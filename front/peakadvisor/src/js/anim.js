// IE cannot apply CSS transforms on SVG elements. (See https://connect.microsoft.com/IE/feedback/details/811744/ie11-bug-with-implementation-of-css-transforms-in-svg)
require('animejs');

anime({
    targets: ['.blue', '.green'],
    translateX: '13rem',
    rotate: 180,
    borderRadius: '8px',
    duration: 2000,
    loop: true
});