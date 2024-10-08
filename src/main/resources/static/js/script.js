console.log("script loaded");

let currentTheme = getTheme();

document.addEventListener('DOMContentLoaded', () => {
    changeTheme();
});



// // TODo
function changeTheme()
{
    // document.querySelector("html").classList.add(currentTheme);

    changePageTheme(currentTheme,currentTheme);
    const  changeThemeButton =  document.querySelector('#theme_change_button');
    
    // changeThemeButton.querySelector("span").textContent = currentTheme == 'light' ? 'Dark':'Light';
    const oldTheme = currentTheme;
    changeThemeButton.addEventListener("click", (event) => {
        
        if(currentTheme === "dark")
            currentTheme = "light";
        else
            currentTheme = "dark";
        
        changePageTheme(currentTheme, oldTheme);

    });
}

function setTheme(theme)
{
    localStorage.setItem("theme",theme);
}

function getTheme()
{
    let theme = localStorage.getItem("theme");

    return theme ? theme : "light" ;
}

function changePageTheme(theme, oldTheme)
{
    setTheme(currentTheme);
    document.querySelector("html").classList.remove(oldTheme);
    document.querySelector("html").classList.add(theme);

    document.querySelector('#theme_change_button').querySelector("span").textContent = theme == 'light' ? 'Dark':'Light';
}