$('.modalClose, .background').on('click', function (){
    $('.modal').addClass('hidden');
});

 $('.allClick').on('click', function (){
    var roof = true;
    $('input:checkbox').each(function (){
        if($(this).prop('checked') === false){
            $('input:checkbox').prop('checked',true);
            roof = false;
            return false;
        }
    });
    if(roof){
        $('input:checkbox').prop('checked', false);
    }
});